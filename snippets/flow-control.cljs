(when (= lang "de") "german")

(if (= lang "de") "german" "english")

(defn which-lang
  [lang]
  (cond
    (= lang "de") "german"
    (= lang "es") "spanish"
    :else "english"))

(defn which-lang
  [lang]
  (case lang
    "de" "german"
    "es" "spanish"
    "english")