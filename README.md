# simple-shop

Technology choice justification

- frontend

I took Tomek's advice to use things I already know and feel confident with and I assumed it's best to pick simplest solution which I feel comfortable in, hence simple JSP page
with form validation based on values gotten from bean.

- backend

I don't know groovy, I know scala only in basics, so Java came as a natural choice to implement backend.
Simple and clear coupling between frontend and backend over doGet/doPost methods

Persistence layer implementation suggestions

My knowledge on such considerations is very limited, but I would go for some modern approach like MongoDB after containing business logic within EJB3 first.

Time consumed

can say precisely, but it took me about 3-4 hours to devise working solution, but spend another few on refactoring, redesigning to better suit asumed model and general tweaks&improvements


How would you adapt the application if item list and stock would have to be fetched over REST from bulk distributor?

I would rebuild Shop class to be able to store dynamic list of items, change JSP to be able to display dynamic contents and add REST service consumer to Shop class.
I'd use Tomcat scheduler to run it periodically once a day.
