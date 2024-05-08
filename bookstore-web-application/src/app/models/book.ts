import { Author } from "./author";
import { Genre } from "./genre";
import { Image } from "./image";
import { Publisher } from "./publisher";

export interface Book {
    isbn?: string,
    title?: string,
    description?: string,
    image?: Image,
    genre?: Genre,
    authors?: Author[],
    publisher?: Publisher,
    publicationDate?: Date
    language?: string,
    pages?: number,
    price?: number
}
