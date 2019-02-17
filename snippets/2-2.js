import React, { useState } from 'react';

function Counter() {
  const [count, setCount] = useState(0);
  const increment = () => setCount(count + 1)

  return (
    <div>
      <p>You clicked {count} times</p>
      <button onClick={increment}>
        Click me
      </button>
    </div>
  );
}

export default Counter
