import React, {useEffect} from "react";
import CarList from "../components/Car/CarList";
import Navbar from "../components/Navbar";
import {useData} from "../contexts/DataContext";
import merolIcon from "../assets/img/merolico.png";

const MyGaragePageLIST = () => {
    const data = useData();
    useEffect(() => {
        data.loadData();
    }, []);
    return (
        <div>
            <div>
                <div style={{
                    width: '100%',
                    display: 'flex',
                    justifyContent: 'space-between',
                    padding: '1vw',
                    background: '#27211e'
                }}>
                    <div style={{fontSize: '175%', color: '#cf4a4a', marginLeft: '2vw'}}>
                        LISTA AUT
                    </div>
                    <div style={{fontSize: '175%', color: '#cf4a4a', marginRight: '2vw'}}>
                        GARASH&nbsp;<img className="logo-img" src={merolIcon} alt={'merol_ikonka'}/>
                    </div>
                </div>
                <Navbar/>
                <div>
                    <CarList data={data}/>
                </div>
            </div>
        </div>
    )
}
export default MyGaragePageLIST;