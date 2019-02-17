import { dark } from 'mdx-deck/themes'
import nightOwl from "prism-react-renderer/themes/nightOwl"
import okaidia from 'react-syntax-highlighter/styles/prism/okaidia'
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

const theme = {
  ...dark,
  fontSizes: [
    "0.75em",
    "1em",
    "1em",
    "1em",
    "1em",
  ],
  codeSurfer: {
    ...nightOwl,
    showNumbers: false
  },
  prism: {
    style: okaidia,
    languages: {
      clojure
    }
  }
}

export default theme
