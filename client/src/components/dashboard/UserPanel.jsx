import React from 'react';

const UserPanel = ({ userData }) => {
  return (
    <div className='flex flex-col space-y-5 items-center'>
      <div className="w-[82px] h-[82px] flex align-middle justify-center rounded-full overflow-hidden">
        <img className='h-[100%] w-[100%] object-cover max-w-[100px]'
          src={userData.avatar_url}
        />
      </div>
      <div className='space-y-1'>
        <h5 className='text-[14px]'>{userData.name}</h5>
        { !userData.preview ? <h5 className='text-[13px] text-[#BDBDBD]'>{userData.id}</h5> : <h5 className='text-[13px] text-[#BDBDBD]'>[Preview]</h5>}
      </div>
    </div>
  );
};

export default UserPanel;
