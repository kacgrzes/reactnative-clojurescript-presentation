(ns react-up-demo.shared.ui
  (:require [re-native.core :refer [touchable-opacity text slider slider] :rename {slider rn-slider}]
            [re-native.icons :refer [icon]]
            [reagent.core :as r]
            [thi.ng.color.core :as c]))

(defn lighten [color]
  (->
    (c/css color)
    (c/analog 0.0 -0.75 0.75)
    c/as-int24
    c/as-css
    deref))

(defn circle-button [{:keys [style on-press button-color]
               :or {
                    style {}
                    on-press #(print "default")
                    button-color "#333"}}
              & children]
  [touchable-opacity
   {:on-press on-press
    :style (merge {
                   :width 50
                   :height 50
                   :align-items "center"
                   :justify-content "center"
                   :padding 10
                   :border-style "solid"
                   :border-width 1
                   :border-color button-color
                   :background-color (lighten button-color)
                   :border-radius 50
                   }style)} (map-indexed #(with-meta %2  {:key %1}) children)])

(defn circle-button-with-icon [{:keys [style icon-name icon-size button-color on-press]
                         :or {style {} icon-size 24 button-color "#111"}}]
  [circle-button {:style style :button-color button-color :on-press on-press}
   [icon {:name icon-name
          :size icon-size
          :color button-color}]])

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

; BUTTONS WITH ICONS

(defn power-button []
  (let [on? (r/atom false)
        handle-press #(do [(print "heyyy")
                           (swap! on? not)])]
    (fn []
      [circle-button-with-icon {:on-press handle-press
                         :icon-name "ios-power"
                         :icon-size 24
                         :button-color (if @on? "#060" "#f00")}])))

(defn minus-button []
  [circle-button-with-icon {:icon-name "ios-remove"}])

(defn add-button []
  [circle-button-with-icon {:icon-name "ios-add"}])