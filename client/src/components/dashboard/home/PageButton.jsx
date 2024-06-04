import { PiFolderOpenLight, PiGraduationCapLight, PiClipboardTextLight, PiCalendarLight } from "react-icons/pi";

export default function PageButton({ text, iconid, url }) {
    let iconProps = [
        <PiGraduationCapLight size={30} color='#00BFFF'/>,
        <PiFolderOpenLight size={30} color='#00BFFF'/>,
        <PiClipboardTextLight size={30} color='#00BFFF'/>,
        <PiGraduationCapLight size={30} color='#00BFFF'/>,
        <PiGraduationCapLight size={30} color='#00BFFF'/>,
        <PiCalendarLight size={30} color='#00BFFF'/>
    ]

    return (
        <button className="flex flex-col bg-white shadow py-4 px-2 items-center w-[80px] rounded-lg hover:bg-slate-50" onClick={() => { window.open(url, '_blank').focus(); }}>
            <div className='mx-2'>{iconProps[iconid]}</div>
            <p className='text-center break-words text-[11px] pt-2'>{text}</p>            
        </button>
    );
}