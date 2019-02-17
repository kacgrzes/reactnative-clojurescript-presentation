import React from 'react'

function HelloWorld(props) {
  return (
    <div>
      Hello {props.name}
    </div>
  )
}

export default HelloWorld

// or

const HelloWorld = ({ name }) => <div>Hello {name}</div>