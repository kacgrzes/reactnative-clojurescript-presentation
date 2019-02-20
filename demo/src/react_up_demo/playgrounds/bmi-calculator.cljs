(ns react-up-demo.playgrounds.bmi-calculator
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def view (r/adapt-react-class (.-View ReactNative)))
(def text (r/adapt-react-class (.-Text ReactNative)))
(def slider (r/adapt-react-class (.-Slider ReactNative)))

(def bmi-data (r/atom {:height 180 :weight 80}))

(defn calc-bmi []
  (let [{:keys [height weight bmi] :as data} @bmi-data
        h (/ height 100)]
    (if (nil? bmi)
      (assoc data :bmi (/ weight (* h h)))
      (assoc data :weight (* bmi h h)))))

(defn custom-slider [param value min max color]
  [slider {:value value :minimum-value min :maximum-value max
           :style {:width "100%"}
           :minimum-track-tint-color color
           :on-value-change (fn [value]
                              (swap! bmi-data assoc param value)
                              (when (not= param :bmi)
                                (swap! bmi-data assoc :bmi nil)))}])

(defn bmi-calculator []
  (let [{:keys [weight height bmi]} (calc-bmi)
        [color diagnose] (cond
                          (< bmi 18.5) ["orange" "underweight"]
                          (< bmi 25) ["green" "normal"]
                          (< bmi 30) ["orange" "overweight"]
                          :else ["red", "obese"])]
        [view {:style {:width "100%"}}
         [text "BMI calculator"]
         [view
          [text "Height: " (int height) " cm"]
          [custom-slider :height height 100 220 color]]
         [view
          [text "Weight: " (int weight) " kg"]
          [custom-slider :weight weight 30 150 color]]
         [view
          [text "BMI: " (int bmi) " "
           [text {:style {:color color}} diagnose]]
          ]]))