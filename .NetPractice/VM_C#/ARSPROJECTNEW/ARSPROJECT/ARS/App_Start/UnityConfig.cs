using System.Web.Mvc;
using Unity;
using Unity.Mvc5;
using ARSREPO;
namespace ARS
{
    public static class UnityConfig
    {
        public static void RegisterComponents()
        {
			var container = new UnityContainer();

            // register all your components with the container here
            // it is NOT necessary to register your controllers

            // e.g. container.RegisterType<ITestService, TestService>();
            container.RegisterType<IAircrafts, Aircrafts>();
         
            container.RegisterType<IAirfare, Airfare>();
            container.RegisterType<IFlight_Schedule, Flight_Schedule>();
            container.RegisterType<IAdmin, AdminRepo>();

            DependencyResolver.SetResolver(new UnityDependencyResolver(container));
        }
    }
}