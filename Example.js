import React, { Fragment } from 'react'
import { Box } from 'rebass'
import { Code } from 'mdx-deck'
import { Split } from 'mdx-deck/layouts'
import { flatten } from 'ramda'

const Example = props => {
  let { js, cljs } = props
  cljs = flatten([cljs])
  js = flatten([js])

  return (
    <Split>
      <Fragment>
        <Box m={3}>
        <h2>ClojureScript</h2>
        {cljs.map(code => {
          return <Code className={'clojure'}>
            {code}  
          </Code>
        })}
        
        </Box>
        <Box m={3}>
        <h2>JavaScript</h2>
        {js.map(code => {
          return <Code className={'javascript'}>
            {code}  
          </Code>
        })}
        </Box>
        

      </Fragment>
    </Split>
  )
}

export default Example