import { useEffect, useState } from 'react';
import { ViewState } from '@devexpress/dx-react-scheduler';
import {
    Scheduler,
    WeekView,
    Appointments,
    AppointmentTooltip
} from '@devexpress/dx-react-scheduler-material-ui';
import CalendarPopup from './CalendarPopup';
import CalendarPopupButton from './CalendarPopupButton';
import { PiArrowSquareOut, PiVideoCamera, PiClipboard } from "react-icons/pi";

const AppointmentContent = ({ ...restProps }) => (
    <div className='m-4 mt-0 rounded-lg text-[11px]'>
        <CalendarPopup data={restProps.appointmentData}/>
        <div className='flex justify-end'>
            <CalendarPopupButton Icon={PiArrowSquareOut} />
            <CalendarPopupButton Icon={PiVideoCamera} enabled={false} />
            <CalendarPopupButton Icon={PiClipboard} text={'Marcar'} />
        </div>
    </div>
);

export default function CalendarElement({ size, userData }) {
    const [schedulerData, setSchedulerData] = useState([]);

    useEffect(() => {
        if(!userData.sections || schedulerData.length != 0) return;

        userData.sections.map((section) => {
            section.sessions.map((session) => {
                let data = {
                    code: section.course.id,
                    startDate: session.start_time.replace("+00:00", "-05:00"),
                    endDate: session.end_time.replace("+00:00", "-05:00"),
                    title: section.course.name,
                    room: session.classroom,
                    teacher: section.teacher.name,
                    type: session.type
                }

                setSchedulerData(prev => [...prev, data])
            })
        })
    }, [])

    return (
        <Scheduler
            data={schedulerData}
            height={size}
        >
            <ViewState />
            <WeekView
                startDayHour={6}
                endDayHour={23}
                cellDuration={60}
            />
            <Appointments/>
            <AppointmentTooltip
                contentComponent={AppointmentContent}
                showCloseButton
            />
        </Scheduler>
    );
}