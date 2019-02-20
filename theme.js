import { dark } from 'mdx-deck/themes'
import nightOwlSurfer from "prism-react-renderer/themes/nightOwl"
import nightOwl from './prism.js'
import clojure from 'react-syntax-highlighter/languages/prism/clojure'

// THEMES:
// base
// big
// book
// code
// comic
// condensed
// dark
// future
// hack
// index
// lobster
// notes
// rye
// script
// swiss
// yellow

console.log(nightOwlSurfer)

const theme = {
  ...dark,
  colors: {
    ...dark.colors,
    background: 'rgb(1, 22, 39)'
  },
  fontSizes: [
    "0.75em",
    "1em",
    "1.5em",
    "2em",
    "3em",
  ],
  codeSurfer: {
    ...nightOwlSurfer,
    showNumbers: false
  },
  prism: {
    style: nightOwl,
    languages: {
      clojure
    }
  }
}

export default theme
