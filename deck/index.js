import intro from './intro.mdx'
import clojure from './clojure.mdx'
import clojurescript from './clojurescript.mdx'
import reagentIntro from './reagent-intro.mdx'
import reagentUsage from './reagent-usage.mdx'
import outro from './outro.mdx'

export { default as theme } from 'theme'

export default [
  ...intro,
  ...clojure,
  ...clojurescript,
  ...reagentIntro,
  ...reagentUsage,
  ...outro
]