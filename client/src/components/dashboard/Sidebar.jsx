import React from 'react';
import { useNavigate } from 'react-router-dom';
import Logo from './SidebarIcon.jsx';
import UserPanel from './UserPanel.jsx';
import SidebarButton from './SidebarButton.jsx';
import { PiDoorOpen } from 'react-icons/pi';

const Sidebar = ({ userData, selectedButton, setSelectedButton }) => {
  const navigate = useNavigate();

  const handleLogout = () => {
    navigate('/oauth/logout');
  };

  return (
    <div className="w-[200px] h-screen bg-white shadow p-3 align-middle">
      <aside>
        <section>
          <div className='text-center flex flex-col space-y-8'>
            <div>
              <Logo />
            </div>
            <div className='flex flex-col'>
              <UserPanel userData={userData} />
            </div>
            <div>
              <SidebarButton text={"Inicio"} iconid={0} selectedButton={selectedButton} setSelectedButton={setSelectedButton} />
              {!userData.preview && <SidebarButton text={"Curricula"} iconid={1} selectedButton={selectedButton} setSelectedButton={setSelectedButton} />}
              <SidebarButton text={"Consultas"} iconid={2} selectedButton={selectedButton} setSelectedButton={setSelectedButton} />
              <SidebarButton text={"Tramites"} iconid={3} selectedButton={selectedButton} setSelectedButton={setSelectedButton} />
              <SidebarButton text={"GoPlatform"} iconid={4} selectedButton={selectedButton} setSelectedButton={setSelectedButton} />
            </div>
          </div>
        </section>
      </aside>

      <div className='bottom-0 absolute p-4'>
        <div className="w-full p-2 h-12 items-center rounded shadow-sm flex flex-row space-x-3 hover:bg-slate-50 text-[13px]">
          <div>
            <PiDoorOpen />
          </div>
          <button onClick={handleLogout}>Log Out</button>
        </div>
      </div>
    </div>
  );
};

export default Sidebar;