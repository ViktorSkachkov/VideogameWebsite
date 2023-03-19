import VideogameCard from "../API_access/VideogameCard";
import {useState, useEffect} from "react";

const HomeDisplay = (props) => {

    useEffect(() => {
        console.log(props.roles);
    }, []);

    return (
        <>
            <center>
                <img src="/69piR5.jpg" width="80%" height="400px"  alt="Currently the image can't load"/>
            </center>
            {props.roles.some(r => r == "CUSTOMER") ? <>
                <h1 className="title">Featured Games</h1>
                <div className="listOfGames">
                    {props.featuredVideogames.map((videogame) => (
                        <VideogameCard videogame={videogame} />
                    ))}
                </div>
                <h1 className="title">Upcoming Games</h1>
                <div className="listOfGames">
                    {props.upcomingVideogames.map((videogame) => (
                        <VideogameCard videogame={videogame} />
                    ))}
                </div>
            </> : <><br/><br/><br/><br/><br/><br/><br/><br/><br/>
            </>}
        </>
    )
}
export default HomeDisplay;