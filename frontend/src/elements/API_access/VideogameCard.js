import '../css/VideogameCard.css';
import {useNavigate} from "react-router-dom";
const VideogameCard = (videogame) => {
    let navigate = useNavigate();

    return (
        <div className="videogameCard"  onClick={() => {
                navigate(`/game/${videogame.videogame.id}`, {
            });
        }}>
            <div>
                <img src="69piR5.jpg" height="400px" width="450px" alt=""/>
            </div>
            <div className="">
                <center>
                    <h1>{videogame.videogame.name}</h1>
                </center>
            </div>
            <div className="lowerPart">
                <b><p className="price">Price: {videogame.videogame.price}</p></b>
                <p className="description">{videogame.videogame.description}</p>
            </div>
        </div>
    )
}
export default VideogameCard;