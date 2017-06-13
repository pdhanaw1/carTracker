import { ClientAPIPage } from './app.po';

describe('client-api App', () => {
  let page: ClientAPIPage;

  beforeEach(() => {
    page = new ClientAPIPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
