import React, { useEffect } from 'react';
import { useSpring, animated } from 'react-spring';

const PopupMessage = ({ message, onClose }) => {
  const animationProps = useSpring({
    opacity: 1,
    from: { opacity: 0 },
    config: { duration: 300 }
  });

  useEffect(() => {
    const autoCloseTimer = setTimeout(() => {
      animationProps.opacity.start(0).then(() => {
        onClose();
      })
    }, 4000);

    return () => clearTimeout(autoCloseTimer);
  });

  return (
    <animated.div style={animationProps}>
      <div className='fixed flex top-4 right-4 bg-white shadow p-4 rounded w-[321px] items-center'>
        <div className='flex flex-col text-left'>
          <p className='text-sm font-bold'>Cuenta no válida!</p>
          <p className='text-sm'>{message}</p>
        </div>
        <button className='ml-auto text-gray-500 hover:text-gray-700' onClick={onClose}>
          &#10005;
        </button>
      </div>
    </animated.div>
  );
};

export default PopupMessage;