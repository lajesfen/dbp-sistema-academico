import Classes from "./Classes";
import InfoHeader from "./InfoHeader";

export default function DashboardHome({ userData }) {
  return (
    <div className='m-9'>
      <div className="w-8xl">
        <InfoHeader userData={userData} />
      </div>
      <div className="flex mt-7">
        <Classes userData={userData} />
      </div>
    </div>
  );
}