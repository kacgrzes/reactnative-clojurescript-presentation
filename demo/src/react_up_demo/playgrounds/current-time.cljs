(ns react-up-demo.playgrounds.current-time
  (:require [reagent.core :as r]
            [react-up-demo.shared.components.button :refer [button]]))

(def ReactNative (js/require "react-native"))

(def view (r/adapt-react-class (.-View ReactNative)))
(def text (r/adapt-react-class (.-Text ReactNative)))

(defonce timer (r/atom (js/Date.)))
(defonce ticker (js/setInterval #(reset! timer (js/Date.)) 1000))

(defn clock []
  (let [time-str (-> @timer .toTimeString (clojure.string/split " ") first)]
    [view
     [text {:style {:font-size 20 :font-weight "300"}} time-str]
     [button {:title "Clear timer!" :on-press #(js/clearInterval ticker)}]]))