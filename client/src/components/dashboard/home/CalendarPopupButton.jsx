export default function CalendarPopupButton({ Icon, text = '', enabled = true }) {

    return (
        <button disabled={!enabled} className={"flex items-center text-white text-[13px] rounded p-1.5 px-5 m-1 gap-1 " + (enabled ? "bg-[#00BFFF]" : "bg-[#D0D0D0]")}>
            {text}
            <Icon size={20}/>
        </button>
    );
}