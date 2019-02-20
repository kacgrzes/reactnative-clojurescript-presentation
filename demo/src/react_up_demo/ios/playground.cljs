(ns react-up-demo.ios.playground
  (:require [reagent.core :as r :refer [atom]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [re-native.core :refer [text text-input view scroll-view image touchable-highlight app-registry react-native]]
            [react-up-demo.shared.components.helloworld :refer [hello-world]]
            [react-up-demo.playgrounds.bmi-calculator :refer [bmi-calculator]]
            [react-up-demo.playgrounds.current-time :refer [clock]]
            [react-up-demo.shared.components.button :refer [button]]))

(def container-style {:border-width 1 :border-color "red" :padding 10 :margin 10})

(defn simple-component []
  [view {:style container-style}
   [text "I am component"]
   [text "I have"
    [text {:style {:font-weight "600"}} " strong"]
    [text {:style {:color "red"}} " and red text."]]])

(defn parent-component []
  [view {:style container-style}
   [simple-component]
   [text "More text here!"]])

(defn lister [items]
  [view {:style container-style}
   (for [item items]
     ^{:key item} [text "Item " item])])

(defn lister-user [] [lister (range 20)])

; MARK: State example
(def click-count (r/atom 0))

(defn click-counter []
  [view
   [text "The atom click-count has value: " @click-count]
   [button {:title "Increment click-count atom!"
            :on-press #(swap! click-count inc)}]])

; MARK: Timeout example
(defn timer-component []
  (let [seconds-elapsed (r/atom 0)]
    (fn []
      (js/setTimeout #(swap! seconds-elapsed inc) 1000)
      [view {:style container-style}
       [text "Seconds elapsed: " @seconds-elapsed]])))

; MARK: Shared state input
(defn atom-input [value]
  [text-input {:value @value :on-change-text #(reset! value (-> %))}])

(defn shared-state []
  (let [val (r/atom "foo")]
    (fn []
      [view
       [text "The value is now: " @val]
       [atom-input val]])))

; MARK: Playground screen
(defn playground-screen []
  (let [greeting (subscribe [:get-greeting])]
    (fn []
      [scroll-view {:contentContainerStyle {:flex-direction "column" :padding 40 :align-items "center"}}
       [text {:style {:font-size 30 :font-weight "100" :margin-bottom 20 :text-align "center"}} @greeting]
       [bmi-calculator]
       [hello-world "world"]
       [clock]
       [shared-state]
       [timer-component]
       [click-counter]
       [simple-component]
       [parent-component]
       [lister-user]])))

(def bmi-screen (r/reactify-component bmi-calculator))