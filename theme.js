import { future } from 'mdx-deck/themes'
import nightOwl from "prism-react-renderer/themes/nightOwl"
import okaidia from 'react-syntax-highlighter/styles/prism/okaidia'
import clojure from 'react-syntax-highlighter/languages/prism/clojure'

export default {
  ...future,
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
  // Customize your presentation theme here.
  //
  // Read the docs for more info:
  // https://github.com/jxnblk/mdx-deck/blob/master/docs/theming.md
  // https://github.com/jxnblk/mdx-deck/blob/master/docs/themes.md

}
