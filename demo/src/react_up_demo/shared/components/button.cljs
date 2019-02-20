(ns react-up-demo.shared.components.button
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))
(def touchable-highlight (r/adapt-react-class (.-TouchableHighlight ReactNative)))
(def text (r/adapt-react-class (.-Text ReactNative)))

(def button-style {:background-color "#999" :padding 10 :border-radius 5})

(defn button [{:keys [title on-press]}]
  [touchable-highlight {:style button-style
                        :on-press on-press}
   [text {:style {:color "white" :text-align "center"}} title]])