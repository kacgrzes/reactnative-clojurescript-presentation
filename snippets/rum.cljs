(ns rum-example.core
  (:require [rum.core :as rum]))

(rum/defc hello [text]
  [:div "Hello " text])

(defn refresh []
  (rum/mount (hello "ReactUp!") (js/document.getElementById "mount")))