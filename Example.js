import React, { Fragment } from 'react'
import { Box } from 'rebass'
import { components } from 'mdx-deck'
import { Split } from 'mdx-deck/layouts'
import { flatten } from 'ramda'

const H2 = components.h2
const Code = components.code

const Example = props => {
  let { js, cljs, fontSize = '20px' } = props
  cljs = flatten([cljs])
  js = flatten([js])

  return (
    <Split>
      <Fragment>
        <Box m={3}>
          <H2>ClojureScript</H2>
          <Box fontSize={fontSize}>
            {cljs.map(code => {
              return <Code className={'clojure'}>
                {code}  
              </Code>
            })}
          </Box>
        </Box>

        <Box m={3}>
          <H2>JavaScript</H2>
          <Box fontSize={fontSize}>
            {js.map(code => {
              return <Code className={'jsx'}>
                {code}  
              </Code>
            })}
          </Box>
        </Box>
      </Fragment>
    </Split>
  )
}

export default Example