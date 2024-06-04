import { PiCalendarLight } from "react-icons/pi";
import ClassesElement from "./ClassesElement";

export default function Classes( { userData } ) {
    return (
        <div className="flex flex-col h-[60vh] max-h-[700px] w-[120vw] max-w-[107rem] bg-white shadow-md rounded-lg px-6 py-4">
            <div className='flex text-[13px] pb-3 items-center font-medium'>
                <PiCalendarLight size={18} className='mr-1'/>
                Mi Matrícula
            </div>
            <hr />
            <div className="text-[11px] flex flex-col space-y-2">
                {userData.sections.map((data) => (
                    <ClassesElement data={data} key={data.id}/>
                ))}
            </div>
        </div>
    );
}