(ns react-up-demo.ios.core
  (:require [reagent.core :as r :refer [atom]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [react-up-demo.events]
            [react-up-demo.subs]
            [re-native.core :refer [text text-input view image touchable-highlight app-registry react-native]]
            [re-native.navigation :refer [create-app-container create-stack-navigator create-bottom-tab-navigator]]
            [react-up-demo.shared.ui :refer [volume-slider
                                             circle-button-with-icon
                                             power-button
                                             minus-button
                                             add-button]]
            [react-up-demo.shared.styles :refer [styles] :rename {styles s}]
            [react-up-demo.ios.playground :refer [playground-screen bmi-screen]]))

(def logo-img (js/require "./images/cljs.png"))

(defn alert [title]
  (.alert (.-Alert react-native) title))

(defn counter []
  (let [seconds (r/atom 0)]
    (fn []
      (js/setTimeout #(swap! seconds inc) 1000)
      [text {:style (get-in s [:counter-text])} "seconds: " @seconds])))

(defn button [content]
  [touchable-highlight {:style (get-in s [:press-me-now-container])
                        :on-press #(alert "HELLO!")}
   [text {:style (get-in s [:press-me-now-text])} content]])

(defn home-screen [props]
  (let [greeting (subscribe [:get-greeting])]
    (fn []
      [view {:style (get-in s [:home-screen-container])}
       [text {:style (get-in s [:greetings])} @greeting]
       [circle-button-with-icon {:icon-name "ios-arrow-back" :icon-size 24}]
       [view {:style (get-in s [:buttons-row])}
        [minus-button]
        [power-button]
        [add-button]]
       [volume-slider
        {:min 0
         :max 10
         :minimum-track-tint-color "red"
         :value 5}]
       [image {:source logo-img
               :style  (get-in s [:logo-style])}]
       [button "press me now"]])))

(def home-stack (create-stack-navigator
                 {:home (r/create-class {:reagent-render home-screen})}))

(def tab-router {:home (r/reactify-component home-stack)
                 :counter (r/reactify-component counter)
                 :playground (r/reactify-component playground-screen)
                 :bmi (r/reactify-component bmi-screen)})

(def tab-navigator (create-bottom-tab-navigator tab-router))

(defn app-root [] [:> (create-app-container tab-navigator) {}])

(defn init []
  (dispatch-sync [:initialize-db])
  (.registerComponent app-registry "ReactUpDemo" #(r/reactify-component app-root)))
