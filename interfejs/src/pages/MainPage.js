import React, {} from "react";
import Navbar from "../components/Navbar";

import bgImage from "../assets/img/garaz.png";
import merolIcon from "../assets/img/merolico.png";

const GaragePage = () => {

    return (
        <div className="menu-container">
            <div className={'backgroundImage'} style={{
                backgroundImage: `url(${bgImage})`,
            }}>
                <div className="on-image menu-text" style={{ top: '0' }}>
                    <font color="#ff4c4c">Witaj</font>
                </div>
                <div className="on-image logo">
                    GARASH&nbsp;<img className="logo-img" src={merolIcon} alt={'merol_ikonka'}/>
                </div>
                <div className={'on-image navbar'}
                     style={{
                         width: '100vw',
                         marginTop: '20%',
                         background: 'linear-gradient(0deg, rgba(6,6,6,1) 0%, rgba(0,0,0,0) 100%)',
                     }}>
                    <Navbar/>
                </div>
            </div>
            <footer>
                <div className="footer menu-text">@PW</div>
            </footer>
        </div>
    )
}
export default GaragePage;