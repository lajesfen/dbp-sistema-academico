export default function ClassesElement({ data }) {
    return (
        <div className="shadow flex flex-row items-center text-[11px] p-3 py-1 space-x-8 align-middle">
            <div className="w-full flex flex-row items-center space-x-8 p-3 align-middle">
                <div className="font-medium">
                    <p>{data.course.level}</p>
                </div>
                <div className="flex flex-col">
                    <p className="font-medium">{data.course.name}</p>
                    <p className="text-[#BDBDBD] text-[9px]">{data.course.id}</p>
                </div>
                <div>
                    <p>{data.teacher.name}</p>
                </div>
                <div>
                    <p>{data.course.credits}</p>
                </div>
                <div>
                    <p>{data.name}</p>
                </div>
            </div>
            <div className="w-full flex flex-row items-center space-x-8 p-3 justify-end align-middle">
                <div className="">
                    <p>Pendiente</p>
                </div>
                <div className="font-bold">
                    <p>{data.course.grade ? data.course.grade.value : "--"}</p>
                </div>
            </div>
        </div>
    );
}