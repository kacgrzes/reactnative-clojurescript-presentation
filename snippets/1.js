import React from 'react'

function HelloWorld(props) {
  return (
    <div>
      Hello {props.name}
    </div>
  )
}

const HelloWorld = ({ name }) => <div>Hello {name}</div>

export default HelloWorld
