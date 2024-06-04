import { PiDoorOpen, PiFiles, PiGraduationCap, PiHouse, PiListMagnifyingGlass, PiNotePencil } from "react-icons/pi";

export default function SidebarButton({ iconid, text, selectedButton, setSelectedButton }) {
    let iconProps = [
        <PiHouse size={18} />,
        <PiGraduationCap size={18} />,
        <PiListMagnifyingGlass size={18} />,
        <PiFiles size={18} />,
        <PiNotePencil size={18} />,
        <PiDoorOpen size={18} />
    ]

    return (
        <button
            className={`w-full my-2 p-2 h-[36px] text-[13px] items-center rounded shadow-sm flex flex-row space-x-2 ${selectedButton === iconid ? 'bg-[#00BFFF] text-[#FFFFFF]' : 'hover:bg-slate-50 text-[#00000]'}`}
            onClick={() => setSelectedButton(iconid)}
        >
            <div>
                {iconProps[iconid]}
            </div>
            <p>
                {text}
            </p>
        </button>
    );
}