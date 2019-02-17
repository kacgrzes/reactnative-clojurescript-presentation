import React, { Fragment } from 'react'
import { Box } from 'rebass'
import { components } from 'mdx-deck'
import { Split } from 'mdx-deck/layouts'
import { flatten } from 'ramda'

const H4 = components.h4
const Code = components.code

const Example = props => {
  let { js, cljs, fontSize = '20px', title = '' } = props
  cljs = flatten([cljs])
  js = flatten([js])

  return [
    <Box key={'title'} style={{
      position: 'absolute',
      width: '100%'
    }}>
      <h2>{title}</h2>
    </Box>,
    <Split key={'split-layout'}>
      <Fragment>
        <Box m={3}>
          <H4>ClojureScript</H4>
          <Box fontSize={fontSize}>
            {cljs.map((code, index) => {
              return <Code key={index} className={'clojure'}>
                {code}  
              </Code>
            })}
          </Box>
        </Box>

        <Box m={3}>
          <H4>JavaScript</H4>
          <Box fontSize={fontSize}>
            {js.map((code, index) => {
              return <Code key={index} className={'jsx'}>
                {code}  
              </Code>
            })}
          </Box>
        </Box>
      </Fragment>
    </Split>
  ]
}

export default Example