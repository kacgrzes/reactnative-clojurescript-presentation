(ns re-native.icons
  (:require [reagent.core :as r]))

(def react-native-vector-icons-Ionicons (js/require "react-native-vector-icons/Ionicons"))

(def Ionicons (aget react-native-vector-icons-Ionicons "default"))

(def icon (r/adapt-react-class Ionicons))
