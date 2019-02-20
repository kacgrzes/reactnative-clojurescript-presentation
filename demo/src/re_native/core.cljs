; https://github.com/priornix/antizer/blob/master/src/antizer/core.cljs

(ns re-native.core
  (:require [reagent.core :as r]))

(def react-native (js/require "react-native"))

(def app-registry (.-AppRegistry react-native))
(def text (r/adapt-react-class (.-Text react-native)))
(def view (r/adapt-react-class (.-View react-native)))
(def image (r/adapt-react-class (.-Image react-native)))
(def touchable-highlight (r/adapt-react-class (.-TouchableHighlight react-native)))
(def touchable-opacity (r/adapt-react-class (.-TouchableOpacity react-native)))
(def slider (r/adapt-react-class (.-Slider react-native)))
