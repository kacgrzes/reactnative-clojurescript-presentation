(ns react-up-demo.ios.core
  (:require [reagent.core :as r :refer [atom]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [react-up-demo.events]
            [react-up-demo.subs]
            [re-native.core :refer [text view image touchable-highlight app-registry react-native]]
            [re-native.navigation :refer [create-app-container create-stack-navigator create-bottom-tab-navigator]]
            [react-up-demo.shared.ui :refer [button volume-slider]]))

(def logo-img (js/require "./images/cljs.png"))

(defn alert [title]
  (.alert (.-Alert react-native) title))

(defn xyz []
  (let [seconds (r/atom 0)]
    (fn []
      (js/setTimeout #(swap! seconds inc) 2000)
      [text {:style {:color "green" :font-size 48}} "seconds: " @seconds])))

(defn home []
  (let [greeting (subscribe [:get-greeting])]
    (fn []
      [view {:style {:flex-direction "column" :margin 40 :align-items "center"}}
       [text {:style {:font-size 30 :font-weight "100" :margin-bottom 20 :text-align "center"}} @greeting]
       [xyz]
       [button {:title "+"}]
       [button {:title "-"}]
       [volume-slider {:min 0 :max 10 :thumb-tint-color "red" :minimum-track-tint-color "red" :value 5}]
       [image {:source logo-img
               :style  {:width 80 :height 80 :margin-bottom 30}}]
       [touchable-highlight {:style {:background-color "#999" :padding 10 :border-radius 5}
                             :on-press #(alert "HELLO!")}
        [text {:style {:color "white" :text-align "center" :font-weight "bold"}} "press me now"]]])))

(def home-stack (create-stack-navigator {:home {
                                                :screen (r/reactify-component home)
                                                :navigation-options {
                                                                     :title "Hello!"}}}))

(def tab-router {:home (r/reactify-component home-stack)
                 :xyz (r/reactify-component xyz)
                 :abc (r/reactify-component xyz)})

(def tab-navigator (create-bottom-tab-navigator tab-router))

(defn app-root [] [:> (create-app-container tab-navigator) {}])

(defn init []
  (dispatch-sync [:initialize-db])
  (.registerComponent app-registry "ReactUpDemo" #(r/reactify-component app-root)))
