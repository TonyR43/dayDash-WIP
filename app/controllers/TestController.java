package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.MapLocation;
import models.Test;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.filters.headers.SecurityHeadersFilter;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Html;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestController extends Controller
{
    private FormFactory formFactory;
    private JPAApi db;

    @Inject
    public TestController(FormFactory formFactory, JPAApi db)
    {
        this.formFactory = formFactory;
        this.db = db;
    }

    public Result getTest()
    {
        return ok(views.html.test.render("Test Text"));
    }

    public Result postTest()
    {
        DynamicForm form = formFactory.form().bindFromRequest();
        String test = form.get("test");
        String wisewords = form.get("wisewords");
        return ok(views.html.test.render(wisewords));
    }

    @Transactional(readOnly = true)
    public Result getTestDb()
    {
        String sql = "SELECT t FROM Test t";
        TypedQuery query = db.em().createQuery(sql, Test.class);
        List<Test> test = query.getResultList();

        return ok(views.html.test.render("Rows: " + test.size()));
    }

    @Transactional
    public Result postTestDb()
    {
        DynamicForm form = formFactory.form().bindFromRequest();
        String testName = form.get("test");
        Test test = new Test();
        test.setTestName(testName);
        db.em().persist(test);

        return redirect("/testdb");
    }

    public Result getLeaflet()
    {
        List<MapLocation> locations = new ArrayList<>();

        MapLocation mapLocation = new MapLocation();
        mapLocation.setLatitude(new BigDecimal("51.508"));
        mapLocation.setLongitude(new BigDecimal("-0.08"));

        MapLocation mapLocation2 = new MapLocation();
        mapLocation2.setLatitude(new BigDecimal("51.500"));
        mapLocation2.setLongitude(new BigDecimal("-0.06"));

        MapLocation mapLocation3 = new MapLocation();
        mapLocation3.setLatitude(new BigDecimal("51.511"));
        mapLocation3.setLongitude(new BigDecimal("-0.048"));

        MapLocation mapLocation4 = new MapLocation();
        mapLocation4.setLatitude(new BigDecimal("51.513"));
        mapLocation4.setLongitude(new BigDecimal("-0.048"));

        locations.add(mapLocation);
        locations.add(mapLocation2);
        locations.add(mapLocation3);
        locations.add(mapLocation4);

        JsonNode json = play.libs.Json.toJson(locations);
        return ok(views.html.leaflet.render(new Html(Json.stringify(json))));
        //return ok(json);
    }

    public Result getNavbarDemo()
    {
        return ok(views.html.navbardemo.render());
    }

}
