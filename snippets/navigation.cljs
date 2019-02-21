(ns re-native.navigation
  (:require [reagent.core :as r]))

(def react-navigation (js/require "react-navigation"))

(def create-app-container (.-createAppContainer react-navigation))

(defn create-stack-navigator [route-configs]
  (.createStackNavigator react-navigation (clj->js route-configs)))

(defn create-bottom-tab-navigator [route-configs]
  (.createBottomTabNavigator react-navigation (clj->js route-configs)))