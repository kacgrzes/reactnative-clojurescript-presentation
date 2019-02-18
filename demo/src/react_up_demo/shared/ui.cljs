(ns react-up-demo.shared.ui
  (:require [re-native.core :refer [touchable-opacity text slider slider] :rename {slider rn-slider}]
            [reagent.core :as r]))

(defn button []
  [touchable-opacity
   {:style {
            :padding 10
            :border-style "solid"
            :border-width 1
            :border-color "red"
            :border-radius 50
            }}
   [text "hello!"]])

(defn slider [{:keys [step min max style thumb-tint-color minimum-track-tint-color maximum-track-tint-color value]}]
  [rn-slider {
              :step step
              :minimum-value min
              :maximum-value max
              :value value
              :style {:width 100}
              :thumb-tint-color thumb-tint-color
              :minimum-track-tint-color minimum-track-tint-color
              :maximum-track-tint-color maximum-track-tint-color}])

(defn volume-slider [keys]
  (let [volume (r/atom (get-in keys [:value]))
        new-keys (assoc keys :value @volume)]
    (fn []
      [:<>
       [text {:style { :color "red" }} (str "Volume " @volume)]
       [slider new-keys]])))