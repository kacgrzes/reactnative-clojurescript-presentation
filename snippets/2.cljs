(ns counter
  :requre [reagent.core :as r])

(defn counter
  []
  (let [click-count (r/atom 0)
       increment #(swap! click-count inc)]
       (fn
         []
         [:div
          "The state has a value: " @click-count
          [:input
           {:type "button"
            :value "Click me!"
            :on-click increment}]])))