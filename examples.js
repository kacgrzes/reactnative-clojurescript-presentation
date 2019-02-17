export const ex1cljs = `(ns hello-world)
  
(defn hello
  [name
  [:div]
    "Hello " name])`

export const ex1js = [`import React from 'react'
        
function Hello(props) {
  return (
    <div>
      Hello {props.name}
    </div>
  )
}

export default Hello`,
`import React from 'react'

const Hello = ({ name }) => <div>{name}</div>

export default Hello
`
]