export default function Header({ headerTitle, Icon }) {
    return (
        <div className="flex w-screen bg-white shadow h-[57px] p-2 items-center">
            <div className='mx-3'><Icon size={26} /></div>
            <p className='text-[20px]'>{ headerTitle }</p>
        </div>
    );
}