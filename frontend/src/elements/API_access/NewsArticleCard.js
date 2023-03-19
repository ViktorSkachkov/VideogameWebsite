import {useNavigate} from "react-router-dom";
import '../css/NewsArticleCard.css';

const NewsArticleCard = (newsArticle) => {
    let navigate = useNavigate();

    return (
        <div className="newsArticleCard" onClick={() => {
            navigate(`/newsArticle/${newsArticle.newsArticle.id}`, {
            });
        }}>
            <div>
                <img src="69piR5.jpg" height="300px" width="450px" alt=""/>
            </div>
            <div>
                <h1>{newsArticle.newsArticle.title}</h1>
                <p className="text">{newsArticle.newsArticle.text}</p>
            </div>
        </div>
    )
}
export default NewsArticleCard;