import axios, { AxiosRequestConfig } from 'axios';
export const JSON_WEB_TOKEN = 'JsonWebToken';

export default class BaseServie {
    protected BASE_URL: string | undefined = 'http://distsys.ch:1450'; //process.env.VUE_APP_BASE_URL;

    protected deleteConfig!: AxiosRequestConfig;
    protected getConfig!: AxiosRequestConfig;
    protected postConfig!: AxiosRequestConfig;
    protected putConfig!: AxiosRequestConfig;

    constructor() {
        console.debug('baseService::constructor', this.BASE_URL);
    }

    protected async DELETE(url: string, config: AxiosRequestConfig = this.getDeleteConfig()) {
        const encodedUrl = encodeURI(url);
        console.info('API Call:=', url);

        try {
            const response = await axios.delete(encodedUrl, config);
            console.info('response', response);
            return response;
        } catch (error) {
            return this.errorhandling(error);
        }
    }

    protected async GET(url: string, config: AxiosRequestConfig = this.getGetConfig()) {
        const encodedUrl = encodeURI(url);
        console.info('API Call:=', url);

        try {
            const response = await axios.get(encodedUrl, config);
            console.info(response.config.url, response);
            return response;
        } catch (error) {
            return this.errorhandling(error);
        }
    }

    protected async POST(url: string, data: any, config: AxiosRequestConfig = this.getPostConfig()) {
        const encodedUrl = encodeURI(url);
        console.info('API Call:=', url, 'data', data);
        try {
            const response = await axios.post(encodedUrl, data, config);
            console.info('response', response);
            return response;
        } catch (error) {
            return this.errorhandling(error);
        }
    }

    protected async PUT(url: string, data: any, config: AxiosRequestConfig = this.getPutConfig()) {
        const encodedUrl = encodeURI(url);
        console.info('API Call:=', url, 'data', data);
        try {
            const response = await axios.put(encodedUrl, data, config);
            console.info('response', response);
            return response;
        } catch (error) {
            return this.errorhandling(error);
        }
    }

    private getDeleteConfig(): AxiosRequestConfig {
        const token = localStorage.getItem(JSON_WEB_TOKEN);

        return {
            method: 'DELETE',
            headers: {
                Authorization: 'Bearer ' + token
            }
        };
    }

    private getGetConfig(): AxiosRequestConfig {
        const token = localStorage.getItem(JSON_WEB_TOKEN);

        return {
            method: 'GET',
            // headers: {
            //     Authorization: 'Bearer ' + token
            // }
        };
    }

    private getPostConfig(): AxiosRequestConfig {
        const token = localStorage.getItem(JSON_WEB_TOKEN);

        return {
            method: 'POST',
            headers: {
                Authorization: 'Bearer ' + token
            }
        };
    }

    private getPutConfig(): AxiosRequestConfig {
        const token = localStorage.getItem(JSON_WEB_TOKEN);

        return {
            method: 'PUT',
            headers: {
                Authorization: 'Bearer ' + token
            }
        };
    }

    private errorhandling(error: any) {
        // Rethrow error
        if (error && error.response && error.response.data) {
            throw error.response.data;
        } else if (error && error.response) {
            throw error.response;
        } else {
            throw error;
        }
    }
}
