import { PiCalendarLight } from 'react-icons/pi';
import CalendarElement from './CalendarElement';
import { useEffect, useState } from 'react';

export default function Calendar({ userData }) {
    const [calendarHeight, setCalendarHeight] = useState(510);

    useEffect(() => {
        const updateCalendarHeight = () => {
          const newHeight = window.innerHeight/2.6;
          setCalendarHeight(newHeight);
        };
    
        updateCalendarHeight();
        window.addEventListener('resize', updateCalendarHeight);
    
        return () => {
          window.removeEventListener('resize', updateCalendarHeight);
        };
      }, []);

    return (
        <div className="flex flex-col h-[45vh] max-h-[700px] w-[120vw] max-w-5xl bg-white shadow-md rounded-lg px-6 py-4">
            <div className='flex text-[13px] pb-3 items-center font-medium'>
                <PiCalendarLight size={18} className='mr-1'/>
                Mi Horario
            </div>
            <hr />
            <div>
                <CalendarElement size={calendarHeight} userData={userData} />
            </div>
        </div>
    );
}