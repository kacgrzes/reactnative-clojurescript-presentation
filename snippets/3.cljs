(ns timer
  (:require [reagent.core :as r]))

(defn timer
  []
  (let [seconds (r/atom 0)
        tick #(swap! seconds inc)]
       (r/create-class
        {:component-did-mount
         #(js/setInterval tick 1000)
         :reagent-render
         (fn
           []
           [:div
            "Seconds: " @seconds])})))