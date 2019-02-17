import { useState, useEffect } from 'react';

function Timer() {
  const [seconds, setSeconds] = useState(0)

  useEffect(() => {
    const timerID = setInterval( () => tick(), 1000);

    return function cleanup() {
      clearInterval(timerID);
    };
  });

  function tick () {
    setSeconds(seconds + 1)
  }

  return (
    <div>
      Seconds: {this.state.seconds}
    </div>
  )
}

export default Timer