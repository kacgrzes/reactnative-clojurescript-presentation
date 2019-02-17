(ns timer
  (:require [reagent.core :as r]))

(defn timer []
  (let [seconds (r/atom 0)
        tick #(swap! seconds inc)]
    (fn []
      (js/setTimeout tick 1000)
      [:div
       "Seconds: " @seconds])))