(ns react-up-demo.shared.components.helloworld
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def text (r/adapt-react-class (.-Text ReactNative)))

(defn hello-world [name]
  [text {:style {:font-size 30 :font-weight "600" :text-align "center"}} "Hey, " name "!"])