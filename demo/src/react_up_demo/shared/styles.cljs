(ns react-up-demo.shared.styles)

(def styles {:counter-text {:color "green"
                            :font-size 48
                            :text-align "center"
                            :padding 40}

             :home-screen-container {:flex-direction "column"
                                     :margin 40
                                     :flex-grow 1
                                     :align-items "center"}
             :greetings {:font-size 30
                         :font-weight "100"
                         :margin-bottom 20
                         :color "blue"
                         :text-align "center"}
             :buttons-row {:flex-direction "row"
                           :width "100%"
                           :justify-content "space-between"}
             :logo-style {:width 100
                          :height 100
                          :margin-bottom 30}
             :press-me-now-container {:background-color "#333"
                                      :padding 10
                                      :border-radius 5}
             :press-me-now-text {:color "white"
                                 :text-align "center"
                                 :font-weight "bold"}})