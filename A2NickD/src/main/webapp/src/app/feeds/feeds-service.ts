import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Feed } from './feed';

const restUrl = 'api/v1/feeds'

@Injectable({
	providedIn: 'root',
})

export class FeedsService {
	constructor(private http: HttpClient) { }

	getAll(): Observable<Feed[]> {
		return this.http.get<Feed[]>(restUrl);
	}
}
