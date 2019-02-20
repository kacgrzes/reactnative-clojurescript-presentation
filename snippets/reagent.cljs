(ns example
  (:require [reagent.core :as r]))

(defn hello [text]
  [:div text])

(defn init []
  (r/render [hello]
            (.getElementById js/document "app")))